# https://www.interviewbit.com/courses/shell/topics/regex-and-functions/

declare -a digitl;
declare -a roman;

digitl[0]=1
roman[0]="I"
digitl[1]=4
roman[1]="IV"
digitl[2]=5
roman[2]="V"
digitl[3]=9
roman[3]="IX"
digitl[4]=10
roman[4]="X"
digitl[5]=40
roman[5]="XL"
digitl[6]=50
roman[6]="L"
digitl[7]=90
roman[7]="XC"
digitl[8]=100
roman[8]="C"
digitl[9]=400
roman[9]="CD"
digitl[10]=500
roman[10]="D"
digitl[11]=900
roman[11]="CM"
digitl[12]=1000
roman[12]="M"

while read -r line
do
    ans=""
    declare -i num=$(($line))
    while [ $num -gt 0 ]
    do
        declare -i ix=12
        declare -i delta=${digitl[$ix]}
        while [ $num -lt $delta ]
        do
            ix=$(($ix-1))
            delta=${digitl[$ix]}
        done

        num=$(( $num - $delta ))
        ans="$ans${roman[$ix]}"
    done

    echo $ans

done < input

