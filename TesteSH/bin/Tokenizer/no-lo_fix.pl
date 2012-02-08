#!/usr/bin/perl

# Fix for an erroneous "no-lo" tokenizer output

# TODO:
# - Make it insensitive to case (making sure that the "s" that is added to the first clitic preserves case)

while(<>) {
    s/(-[nv]o) -l([ao]s?)/\1s -\2/g;
    print;
}
