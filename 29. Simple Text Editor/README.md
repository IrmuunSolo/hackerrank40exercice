# Simple Text Editor

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/simple-text-editor/problem?isFullScreen=true)

## Бодлогын тайлбар

Энгийн текст редактор хэрэгжүүл. Эхлээд редактор S хоосон тэмдэгт мөр агуулна. Дараах 4 төрлийн Q үйлдлийг гүйцэтгэнэ:

1. append(W) - S тэмдэгт мөрийн төгсгөлд W тэмдэгт мөрийг нэмнэ
2. delete(k) - S тэмдэгт мөрийн сүүлийн k тэмдэгтийг устгана
3. print(k) - S тэмдэгт мөрийн k-р тэмдэгтийг хэвлэнэ
4. undo() - Сүүлийн 1 эсвэл 2 төрлийн үйлдлийг буцаана (S-ийг уг үйлдэл хийгдэхээс өмнөх төлөвт оруулна)

**Жишээ:**

S = 'abcde'\
ops = ['1 fg', '3 6', '2 5', '4', '3 7', '4', '3 4']

```
operation
index   S       ops[index]  explanation
-----   ------  ----------  -----------
0       abcde   1 fg        append fg
1       abcdefg 3 6         print the 6th letter - f
2       abcdefg 2 5         delete the last 5 letters
3       ab      4           undo the last operation, index 2
4       abcdefg 3 7         print the 7th characgter - g
5       abcdefg 4           undo the last operation, index 0
6       abcde   3 4         print the 4th character - d
```

**Гаралт:**

```
f
g
d
```

**Оролтын формат**

Эхний мөрөнд Q бүхэл тоо (үйлдлийн тоо)
Дараагийн Q мөр бүрд үйлдлийн төрөл ба шаардлагатай аргументууд өгөгдөнө

**Хязгаарлалт:**

- 1 ≤ Q ≤ 10^6
- 1 ≤ k ≤ |S|
- Бүх W тэмдэгт мөрүүдийн нийт урт ≤ 10^6
- Устгах үйлдлүүдийн нийт k ≤ 2*10^6
- Бүх тэмдэгтүүд жижиг англи үсэг
- Үйлдлүүдийн дараалал гүйцэтгэх боломжтой байх баталгаатай

**Гаралтын формат**

3-р төрлийн үйлдэл бүрт k-р тэмдэгтийг шинэ мөрөнд хэвлэ

## Бодолт

Энэ бодлогыг stack ашиглан шийдэж болно. undo үйлдлийг хялбархан хэрэгжүүлэхийн тулд S тэмдэгт мөрийн өмнөх төлөвүүдийг хадгалах хэрэгтэй.

1. Stack ашиглан S-ийн түүхийг хадгалах

```
        int Q = Integer.parseInt(br.readLine());
        StringBuilder S = new StringBuilder();
        Stack<String> history = new Stack<>();
```

2. append, delete үйлдэл бүрийн өмнө S-ийн одоогийн төлөвийг stack-д хийх

```
            switch (type) {
                case 1: // append
                    history.push(S.toString());
                    S.append(op[1]);
                    break;
                case 2: // delete
                    history.push(S.toString());
                    int k = Integer.parseInt(op[1]);
                    S.delete(S.length() - k, S.length());
                    break;
```


3. undo үед stack-аас сүүлд хийсэн төлөвийг авах

```
                case 4: // undo
                    if (!history.isEmpty()) {
                        S = new StringBuilder(history.pop());
                    }
                    break;
```

4. print үед одоогийн S-ээс k-р тэмдэгтийг хэвлэх

```
                case 3: // print
                    int pos = Integer.parseInt(op[1]) - 1;
                    bw.write(S.charAt(pos) + "\n");
                    break;
```

## Submit screenshot

![Submit](/images/29.submit.png)

