#!/usr/bin/perl

# --------------
# Post-tokenizer
#
# Rationale:
# The tagger wes trained over a corpus that had the ambiguous contractions
# still in contracted form, allowing the tagger to decide if the token is
# a contraction or instead, a single word (ex: "consigo" might be "consigo/V"
# or "com/PREP si/PRS", the latter being tagged as "consigo/PREPPRS"). As
# such, after the tagger has run, we need to scan the corpus looking for such
# tokens and, upon finding a token that was tagged as a contraction, we
# expand it.


# The "ambiguous" contractions hash
my %contr = (
	consigo => "com_/PREP si/PRS",
	desse	=> "de_/PREP esse/DEM",
	desses	=> "de_/PREP esses/DEM",
	deste	=> "de_/PREP este/DEM",
	destes	=> "de_/PREP estes/DEM",
	mas	=> "me_/CL as/CL",
	na	=> "em_/PREP a/DA",
	nas	=> "em_/PREP as/DA",
	no	=> "em_/PREP o/DA",
	nos	=> "em_/PREP os/DA",
	pela	=> "por_/PREP a/DA",
	pelas	=> "por_/PREP as/DA",
	pelo	=> "por_/PREP o/DA",
);

# The ambiguous tags
$ambigTags = "PREPPRS|PREPDEM|PREPDA|CLCL";

# Main 
while (<>) {
	s/(\w+)\/(?:$ambigTags)/expand($1)/oge;	
	print;
}

# Expands contractions
sub expand {
	$word = shift;
	$expansion = $contr{lc $word};
	if (defined($expansion)) {
		$expansion = ucfirst $expansion if ($word =~ /^[[:upper:]]/);
		$expansion = uc $expansion if ($word =~ /^[[:upper:]][[:upper:]]/);
		return $expansion;
	} else {
		return $word;
	}
}
