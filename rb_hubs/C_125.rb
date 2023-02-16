gets
array = gets.split(" ").map{ |n| n.to_i}

def elments_times(array)
  negative_times = 0
  zero_times = 0
  n1_times = 0
  ng1_times = 0
  array.each do |n|
      if n < 0
        negative_times += 1
      elsif n == 0
        zero_times += 1
      end
  end
  return negative_times, zero_times
end

def mul_array(array)
  array.inject(1){|prev, n| prev *= n }
end

array.sort!

negative_times, zero_times = elments_times(array)

pre_mul = mul_array(array)

result=0
ar_max = array.max
ar_min = array.min
pos_arr = array.select{|n| n > 0}
neg_arr = array.select{|n| n < 0}
is_all_positive = negative_times == 0 ? true : false
is_all_negative = negative_times == array.length - zero_times ? true :false
is_one_include = array.include?(1) || array.include?(-1)


if pre_mul > 0
  if is_all_positive || is_all_negative
    array[-1] -= 1
    array[0] += 1
    result = mul_array(array)
  else
    array[array.find_index(pos_arr[0])] += 1
    array[array.find_index(neg_arr[-1])] -= 1
    result = mul_array(array)
  end

elsif pre_mul < 0
   if is_all_negative
    array[-1] += 1
    array[0] -= 1
    result = mul_array(array)
   elsif is_one_include
    result = 0
   else
    array[array.find_index(pos_arr[0])] -= 1
    array[array.find_index(neg_arr[-1])] += 1
    result = mul_array(array)
   end

elsif zero_times == 1 && negative_times % 2 == 0
  if is_all_positive
    array[0] += 1
    array[-1] -= 1
    result = mul_array(array)
  elsif is_all_negative
    array[-1] += 1
    array[-2] -= 1
    result = mul_array(array)
  else
    array[array.find_index(0)] += 1
    array[array.find_index(neg_arr[-1])] -= 1
    result = mul_array(array)
  end

elsif zero_times == 1 && negative_times % 2 > 0
  if is_all_negative
    array[-1] -= 1
    array[0] += 1
    result = mul_array(array)
  elsif
    array[array.find_index(0)] -= 1
    array[array.find_index(pos_arr[0])] += 1
    result = mul_array(array)
  end

elsif zero_times == 2
  if negative_times % 2 > 0
    array[array.find_index(0)] += 1
    array[array.find_index(0)] -= 1
    result = mul_array(array)
  end
end


puts result
