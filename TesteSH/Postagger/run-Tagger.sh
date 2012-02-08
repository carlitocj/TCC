#!/bin/bash

MYDIR=$(cd $(dirname $0); pwd -P)
CHUNKER_DIR=$MYDIR/Chunker
TOKENIZER_DIR=$MYDIR/Tokenizer
TAGGER_DIR=$MYDIR/Tagger

# Run pipeline
iconv -f UTF-8 -t ISO-8859-1 -c |
$CHUNKER_DIR/run-Chunker.sh 2>/dev/null |
$TOKENIZER_DIR/run-Tokenizer.sh 2>/dev/null |
$TAGGER_DIR/run-Tagger.sh 2>/dev/null |
$TOKENIZER_DIR/post-tok.pl |
iconv -f ISO-8859-1 -t UTF-8 -c
