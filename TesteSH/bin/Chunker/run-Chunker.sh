#!/bin/bash

MYDIR=$(cd $(dirname $0); pwd -P)

$MYDIR/chunker-one |
tr -d '\n' |
sed 's#</p>#&\n#g' |
sed 's#\( *</[sp]> *\)\+#\n#g' |
sed 's# *<[sp]> *##g'
