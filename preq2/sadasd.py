# print((-1)**0)

def factorial(n):
    result = 1
    for i in range(1, n+1):
        result *= i
    return result

result = 0
x = 2
n = 2
result += ((-1) ** n) * (x ** (2 * n + 1)) / factorial(2 * n + 1)
# print(result)
# print(factorial(n*2))

# Taylor series for sine around 0 (Maclaurin series)
def taylor_sin0(x, k):
    result = 0
    for n in range(k):
        result += ((-1) ** n) * (x ** (2 * n + 1)) / factorial(2 * n + 1)
    return result

print(taylor_sin0(6.28, 15))