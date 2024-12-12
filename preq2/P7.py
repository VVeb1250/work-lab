pi = 3.141592653589793

def factorial(n):
    result = 1
    for i in range(1, n+1):
        result *= i
    return result

# Taylor series for sine around 0 (Maclaurin series)
def taylor_sin0(x, k):
    result = 0
    for n in range(k):
        result += ((-1) ** n) * (x ** (2 * n + 1)) / factorial(2 * n + 1)
    return result

# Taylor series for sine around pi/2
def taylor_sin_halfpi(x, k):
    halfpi = pi / 2
    result = 1
    for n in range(1, k):
        result += ((-1) ** n) * ((x - halfpi) ** (2 * n)) / factorial(2 * n)
    return result

# Taylor series for cosine around 0 (Maclaurin series)
def taylor_cos0(x, k):
    result = 1
    for n in range(1, k):
        result += ((-1) ** n) * (x ** (2 * n)) / factorial(2 * n)
    return result



print('taylor_sin0(pi/4, 4)=', taylor_sin0(pi/4, 4))
print('taylor_sin_halfpi(pi/4, 4)=', taylor_sin_halfpi(pi/4, 4))
for x in [0, pi/6, pi/2, pi, pi*2]:
    print(("x = {:.2f}: sin:0,k15 = {:.4f}, sin:pi/2,k15 = {:.4f}").format(x, taylor_sin0(x, 15),
taylor_sin_halfpi(x, 15)))
print('\ntaylor_cos0(pi/4, 4)=', taylor_sin0(pi/4, 4))
for x in [0, pi/6, pi/2, pi, pi*2]:
    print("x = {:.2f}: cos:0,k15 = {:.4f}".format(x, taylor_cos0(x, 15)))