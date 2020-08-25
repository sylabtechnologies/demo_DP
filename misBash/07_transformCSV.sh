# https://www.interviewbit.com/problems/transform-csv/
# SET IFS TO COMMA & NEST

IFS=,
while read -r line
do
    declare -a fields
    declare -i len=0
    for word in $line
    do
        fields[$len]=$word
        len=$(($len+1))
        echo "$word"
    done

    echo "${fields[0]},${fields[1]},${fields[2]},${fields[3]},${fields[5]},+${fields[4]}-${fields[6]}"

done < input

