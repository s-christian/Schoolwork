# Obtained from vigenere_length_guess.py ...
L = 5
ciphertext = "UMTWQWUASQSQTMWGYMJISDALKGPVPZWDUTRVTWHPGZOAVWOQDIDKLSENUVRPAFBWIGDVZQGZMJMFYGAYJEMKEFPVZXZUVRTSDBTGMXICXGUVEIJQAEQWAVDLGDMKMLTWFKZFQHSMXLDEAXIMSMFIWMLFTPEFPAPILTMHELQZJTSDBZJLTMHSJXLMMLUALASKQSENQWQHJUDTRYANQXZQAAPWQVLRVDMRYDMBTRYFPPGADKFPSFQZRTIPPRWHMCMXUVOQQEMWJYDWHMFSOCMEMJZYLFPPQGGBSSOTMYINQZTXAEIOEEBHOVALHWCFADPQTQZTREKAZYDAESIFQDPVARQYHEKAPPXUVGSDGVEEJUTJTSGATRYNMQSJQKZJXUVHEJQPZYKQAKEFPJCMFSQYKMBBSIJQICSXQDPVQRCYIJMTTQWQBZEFPMDTWOQLPDKESIFQDPVEKPJTGEOPXKGKSEFGXAIJTIYHGRUPDLTIEMLDMBYADMDEKFZZRYYWCEDBZTRUUXWILAXCINQVEQWRZZQVQTTFWDIEIDKAEIHBQYKAZBZXZQAEVWQBKEFPUPXZALTGSXTJOFAKVMFSXPSHXMTWZMBDSXRLELWZHTEUOWFRLUBSMYTBTQWFWRILFWDISMADSGZIDMUMVMXZUATWEKAFFKFQEYLQNZVHUAESDMVOFSXTMAAFPLTZUTZWGBPTGSXNWSMDQDLUMBZXZDWHWZUUDIDRCASFTQDWOAZOSACCTILXGEECQBZXZQASMHNBSIJQQDRGFPTRYECCTJUATRYUVELAEJTJLTMJFMFSYIOUBKEDYWDXSXTXIFUVELWUZOIYDMPDKAUPXAYMZVGFPPVROPPVAEPGIJKVPEJXGELWEIXIXQMWMFSAESOMZOWLTMZGWMVHMLTUPFLTMCIFAETWQACCMFECWEJOQECGRBSIEMVSELFWPWRNMWXWPZZYFPJJAZMZGIKMATRVUIYMKXMDFQOWCEDDMPJKPKZQEQZNIKGZCSMZLDMLIQELZQZDYJRJCMYTBLRVXMQXRFPPWLDMPXKFIVIQACHELQZHEJPJTXKQFEVWYMOSOZBZAFUAELWNIEXWDGKAZQZPXZMBYSTXMXSDQQDASEPPHTKELZWEHLRVOWZPWPJJFJQMKIKLESMUTIQIOTWFVKBZPZAACDAWDMZYLANDMYTBZJDMVOFDAWVELFPPGJAEOWGRELXWDIRERQZDXZQZPF"


def letter_frequency(shift):
    extracted = [ciphertext[i] for i in range(shift, len(ciphertext), L)]
    print("Every 5th letter starting at letter index", shift, ":", extracted)
    counts = [extracted.count(chr(x)) for x in range(65, 91)]
    return counts


letters = [chr(x) for x in range(65, 91)]
shift = int(input("Shift (which letter to start at) : "))
counts = letter_frequency(shift)
frequencies = sorted(list(zip(letters, counts)), key=lambda x: x[1], reverse=True)
for pair in frequencies:
    print(pair[0], ":", pair[1])
