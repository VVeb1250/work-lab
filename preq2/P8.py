def factorial(n):
    res = 1
    for i in range(n):
        res = res * (i + 1)
    return res

def taylor_exp0(x, k):
    result = 0
    for n in range(k):
        result += (x ** n) / factorial(n)
    return result


# print(taylor_exp0(-1,4))
# print(taylor_exp0(-1,7))
# print(taylor_exp0(9,4))
# print(taylor_exp0(9,7))
# print(taylor_exp0(0,15))

# print('taylor_exp0(0,15) =', taylor_exp0(0,15))
# print('taylor_exp0(1,15) =', taylor_exp0(1,15))
# print('taylor_exp0(2,15) =', taylor_exp0(2,15))
# print('taylor_exp0(5,15) =', taylor_exp0(5,15))
# print('taylor_exp0(5,10) =', taylor_exp0(5,10))

# print(taylor_exp0(-1,0))
# print(taylor_exp0(-1,1))
# print(taylor_exp0(-1,2))
# print(taylor_exp0(-1,4))
# print(taylor_exp0(-1,7))
# print(taylor_exp0(-1,15))
# print(taylor_exp0(1,1))
# print(taylor_exp0(1,2))
# print(taylor_exp0(1,4))
# print(taylor_exp0(1,7))
# print(taylor_exp0(1,15))
# print(taylor_exp0(1,25))
# print(taylor_exp0(3,2))
# print(taylor_exp0(3,4))
# print(taylor_exp0(3,7))
# print(taylor_exp0(3,15))
# print(taylor_exp0(3,25))
# print(taylor_exp0(3,50))
# print(taylor_exp0(9,4))
# print(taylor_exp0(9,7))
# print(taylor_exp0(9,15))
# print(taylor_exp0(9,25))
# print(taylor_exp0(9,50))