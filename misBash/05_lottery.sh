# generate 1-50 randoms

for (( i = 0; i < 5; i++ ))
do
  echo $(( (1 + RANDOM) % 50 ))
done
