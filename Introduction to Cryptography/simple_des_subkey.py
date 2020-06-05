def subkey(K, i):
    # 9 bit master key, only need to shift i - 1 times.
    # For example, on round 1, we start at the very first bit (inclusive) which requires no shift. This is why it's i - 1
    # We mod 9 to loop back around. If we were on the 10th round, we would start back at the very first bit again
    shift = (i - 1) % 9

    # This is literally binary addition. "K << 9" is simply K with 9 trailing 0s
    # The end result is simply K twice, since we are adding to a number with 9 zeroes after it, which is like appending
    # Only need to repeat K twice since when we mod the shift size, it goes back to the beginning
    KK = K + (K << 9)

    # We are creating the mask that we will use to & it with y to get our desired 8-bit key length
    # shift zeroes followed by 8 ones followed by (10 - shift) zeroes
    # y is K twice, which is 9 * 2 = 18 bits. To get 8 bits, we take 10 off.
    # The mask "highlights" what we want
    mask = 255 << (10 - shift)

    # Take these digits, then drop the trailing (10-j) zeroes
    k = (KK & mask) >> (10 - shift)

    # Round 1:
    # shift = 0
    #
    # K                             -   010101101
    # KK                            -   010101101 010101101
    # mask                          -   111111110 000000000
    # KK & mask                     -   010101100 000000000
    # (KK & mask) >> (10 - shift)   -   01010110
    #                                   ^ the 0 stays because it needs to be 8 bits, and all binary numbers have an infinite number of leading zeroes
    # Round 2:
    # shift = 1
    #
    # K                             -   010101101
    # KK                            -   010101101 010101101
    # mask                          -   011111111 000000000
    # KK & mask                     -   010101101 000000000
    # (KK & mask) >> (10 - shift)   -   10101101
    #                                   ^ no need for a zero since we already have 8 bits

    # etc...

    return k


# Think that binary numbers have an infinite numbers of 0s in front of them,
# whereas they have nothing behind them.
K = 0b010101100
print("--- Master Key: {0:b} ---".format(K))

k1 = subkey(K, 1)
print("Subkey 1:{0:10b} = {1}".format(k1, int(k1)))

k2 = subkey(K, 2)
print("Subkey 2:{0:10b} = {1}".format(k2, int(k2)))

k3 = subkey(K, 3)
print("Subkey 3:{0:10b} = {1}".format(k3, int(k3)))
print(int(0b110100100001))