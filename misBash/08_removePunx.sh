# https://www.interviewbit.com/problems/remove-punctuations/
# del || sedquote

IFS='\.!@#$%^&*()_-+={}[];:"`/>?,<~|\\'
while read -r line
do
    declare -a tokens
    declare -i len=0
    for word in $line
    do
        tokens[$len]=$word
        len=$(($len+1))
    done

    declare -i count=0
    res=""
    for word in ${tokens[@]}
    do
        res="$res$word"
        count=$(($count+1))
        if [ $count -le $len]
        then
           res="$res "
        fi
    done

    echo "$res" | sed 's/\x27//g'

done < input
