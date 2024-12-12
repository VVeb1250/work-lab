def factorial(n):
    res = 1
    for i in range(n):
        res = res * (i + 1)
    return res

# print('Factorial(12) = ', factorial(12))
# for i in range(8):
#     print('i=', i, '; factorial =', factorial(i))