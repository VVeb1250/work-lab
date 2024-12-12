def factorial(x):
    total = 1
    for i in range(x):
        total *= i+1
    return total


def taylor_exp0(x, k):
    result = 0
    for i in range(k+1):
        result += (x**i)/factorial(i)
    return result


if __name__ == '__main__':
    print('taylor_exp0(0,15) =', taylor_exp0(0, 15))
    print('taylor_exp0(1,15) =', taylor_exp0(1, 15))
    print('taylor_exp0(2,15) =', taylor_exp0(2, 15))
    print('taylor_exp0(5,15) =', taylor_exp0(5, 15))
    print('taylor_exp0(5,10) =', taylor_exp0(5, 10))

