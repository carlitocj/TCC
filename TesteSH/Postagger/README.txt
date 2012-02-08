The tagger works as a command line filter tool (it reads input from stdin and writes to stdout). Accordingly, it is meant to be used as part of pipe constructs in the (UNIX/Linux) command line.

Example:
$ cat input.txt | /path/to/tagger/run-Tagger.sh > output.txt

The input text must encoded using UTF-8. The output uses the same encoding.

The underlying POS tagger that is MXPOST, by Adwait Ratnaparkhi. A model for the POS tagger is provided, but you must get the POS tagger yourself since we cannot redistribute that software. The MXPOST tagger can be downloaded at the following address: ftp://ftp.cis.upenn.edu/pub/adwait/jmx/jmx.tar.gz

You must set the path to your local installation of MXPOST. For this, edit the Tagger/run-Tagger.sh script and set the MXPOST_JAR variable.

