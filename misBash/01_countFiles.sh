# count files in each root subdir

cd /
declare -a dirs=($(ls /))

for d in  ${dirs[@]}
do
   cd /
   if [ -r $d]
   then
    cd $d

    declare -a files=($(ls -p | grep -v /))
    count=0
    for f in  ${files[@]}
    do
      count=$((count + 1))
    done

    echo $pwd $count files
   fi
done



