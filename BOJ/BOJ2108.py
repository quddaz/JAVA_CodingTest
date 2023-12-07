import sys
from collections import Counter

# 평균
def mean(numbers):
    return round(sum(numbers) / len(numbers))

# 중앙
def median(numbers):
    sorted_numbers = sorted(numbers)
    return sorted_numbers[len(numbers)//2]

# 최빈
def mode(numbers):
    counter = Counter(numbers)
    max_count = max(counter.values())
    max_list = [num for num, count in counter.items() if count == max_count]

    # 최빈값이 여러 개인 경우 두 번째로 작은 값을 찾음
    if len(max_list) == 1:
        return max_list[0]
    else:
        return min(max_list)

'''
    count_dict = {} 

    for num in numbers:
        if num in count_dict:
            count_dict[num] += 1
        else:
            count_dict[num] = 1

    max_count = max(count_dict.values())
    result = [num for num, count in count_dict.items() if count == max_count]

    if len(result) == 1:
        return result[0]
    else:
        return min(result)
    //시간 초과 컬렉션의 Counter 사용해야함
'''

# 범위
def range_calculator(numbers):
    return max(numbers) - min(numbers)


N = int(sys.stdin.readline())
numbers = [int(sys.stdin.readline()) for _ in range(N)]


print(str(mean(numbers)))
print(str(median(numbers)))
print(str(mode(numbers)))
print(str(range_calculator(numbers)))
