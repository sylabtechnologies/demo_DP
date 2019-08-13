# generate 60000:63000 primes

#start=60000
#end=63000

start=3
end=1000

numprimes=0
declare -a primes

for ((number=$start; number<=$end; number++))
do
  flag=0
  for ((i=$2; i <= number / 2; i++))
  do
    if test `expr $number % $i` -eq 0  
    then
      flag=1
      break
    fi

    if test $flag -eq 0
    then
      primes[$numprimes] = $number
      numprimes=$((numprimes + 1))
    fi
  done
done

echo ${primes[@]}
