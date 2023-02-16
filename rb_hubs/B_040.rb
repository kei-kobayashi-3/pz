n,T = gets.split(" ")
S = gets.split(" ")


nn = n.to_i
TT = T.split("")
SS = S.map{|ar| ar.split("")}
FF = ("a".."z").to_a

hash = TT.zip(FF).to_h

nn.times do
    SS = SS.map do |string|
        string.map do |s|
            hash[s]
        end
    end
end

res = SS.map do |se|
    se.join("")
end
puts res.join(" ")
