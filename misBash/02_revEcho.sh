# reverse string & echo thyself

var=$0
copy=${var}

len=${#copy}
for((i=$len-1;i>=0;i--)); do rev="$rev${copy:$i:1}"; done

echo $rev
