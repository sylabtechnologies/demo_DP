# generate unique id from md5sum /etc/passwd

myId=$(md5sum /etc/passwd)
echo $myId

len=${#myId}

res=""
for ((i=0; i<$len; i++))
do
  ttm="${myId:$i:1}"
  if [[ $ttm == [0-9] ]]
  then
    res="$res$ttm"
  fi
done

echo ${res:0:6}
