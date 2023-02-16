h,w = gets.split(" ").map(&:to_i)
lis = []
h.times{lis << gets.split(" ")}

has = {}

h.times do |i|
    target = lis[i].map(&:to_i)
    half = target.sum / 2
    sum = 0
    index = 0
    target.each_with_index do |val,j|
        sum += val
        if sum == half
            has[i] = j
            break
        end
    end
end

if has.length == h
    puts "Yes"
    has.each do |k,v|
        res = Array.new(w){"B"}
        res[0..v] =["A"] *( v + 1)
        puts res.join()
    end
else
    puts "No"
end
