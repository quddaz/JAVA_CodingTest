N = input()
count = [0] * 10
result = 0

for digit in N:
    count[int(digit)] += 1

# 6과 9를 동일하게 취급
count[6] = (count[6] + count[9] + 1) // 2
count[9] = 0

# 0부터 9까지의 숫자 중 가장 많이 필요한 세트의 개수 찾기
result = max(count)

print(result)