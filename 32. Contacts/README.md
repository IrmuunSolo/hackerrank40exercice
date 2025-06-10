# Contacts

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/contacts/problem?isFullScreen=true)

## Бодлогын тайлбар

Бид өөрсдийн Контактын програмаа хийх гэж байна! Энэ програм нь дараах 2 төрлийн үйлдлийг гүйцэтгэх ёстой:

1. add name - name нь холбоо барих хүний нэрийг илэрхийлсэн тэмдэгт мөр. Энэ нь програманд шинэ холбоо барих хүн болгон хадгална.

2. find partial - partial нь хайлт хийх хэсэгчилсэн нэрийг илэрхийлсэн тэмдэгт мөр. Энэ нь тухайн хэсэгчилсэн нэрээр эхэлсэн холбоо барих хүмүүсийн тоог тоолж, шинэ мөрөнд хэвлэнэ.

n ширхэг add ба find үйлдлийг өгөгдсөн дарааллаар гүйцэтгэнэ.

**Жишээ**

Дараах үйлдлүүдийг гүйцэтгэвэл:

```
add ed
add eddie
add edward
find ed
add edwina
find edw
find a
```

- Эхний 3 add үйлдэл нь 'ed', 'eddie', 'edward' нэрүүдийг нэмнэ.
- Дараагийн find ed үйлдэл нь эдгээр 3 нэрийг тохируулна ('ed' нь бүтэн нэртэй тохирч байгааг анхаарна уу).
- Дараа нь 'edwina' нэмээд find edw гэвэл 2 нэр тохирно: 'edward' ба 'edwina'.
- Эцэст нь find a үйлдэлд 'a' гэж эхэлсэн нэр олдсонгүй. Тиймээс [3, 2, 0] массив буцна.

**Функцийн Тодорхойлолт**

contacts функцийг доорх дагуу гүйцээнэ үү.

**Параметрүүд**

- List<List<String>> queries: гүйцэтгэх үйлдлүүд

**Буцаах Утга**

- List<Integer>: find үйлдэл бүрийн үр дүн

**Оролтын Формат**

Эхний мөрөнд гүйцэтгэх үйлдлийн тоо n (queries[]-ийн хэмжээ) байна. Дараагийн n мөр бүрт queries[i] тэмдэгт мөр байна.

**Хязгаарлалтууд**

- 1 ≤ n ≤ 10^5
- Нэрийн урт 1-21
- Хэсэгчилсэн нэрийн урт 1-21
- Нэр ба хэсэгчилсэн нэр зөвхөн жижиг англи үсгээр
- add үйлдэлд давхардсан нэр байхгүй

**Жишээ Оролт**

```
4
add hack
add hackerrank
find hac
find hak
```

**Жишээ Гаралт**

```
2
0
```

**Тайлбар**

- 'hack' нэртэй холбоо нэмнэ
- 'hackerrank' нэртэй холбоо нэмнэ
- 'hac' гэж эхэлсэн холбооны тоог олно. 2 холбоо тохирно
- 'hak' гэж эхэлсэн холбоо олдсонгүй, 0 буцна

## Бодолт

Тайлбар:

1. TrieNode класс: Trie модны зангилааг төлөөлнө. children нь дараагийн тэмдэгтүүдийн зангилаануудыг хадгална. count нь тухайн зангилаанаас эхэлсэн нэрсийн тоог хадгална.

```
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0; 
}
```

2. add үйлдэл: Нэрийг Trie-д нэмнэ. Тэмдэгт бүрийг дамжихдаа тоог нэмэгдүүлнэ.

```
        List<Integer> results = new ArrayList<>();
        TrieNode root = new TrieNode();
        
        for (List<String> query : queries) {
            String operation = query.get(0);
            String word = query.get(1);
            
            if (operation.equals("add")) {
                
                TrieNode current = root;
                for (char c : word.toCharArray()) {
                    current.children.putIfAbsent(c, new TrieNode());
                    current = current.children.get(c);
                    current.count++; 
                }
```

3. find үйлдэл: Өгөгдсөн угтварт тохирох нэрсийн тоог олно. Хэрэв угтвар олдвол тухайн зангилааны count утгыг буцаана, олдохгүй бол 0.

```
            } else if (operation.equals("find")) {
                
                TrieNode current = root;
                boolean found = true;
                for (char c : word.toCharArray()) {
                    if (!current.children.containsKey(c)) {
                        found = false;
                        break;
                    }
                    current = current.children.get(c);
                }
                results.add(found ? current.count : 0);
            }
        }
        
        return results;
```


## Submit screenshot

![Submit](/images/32.submit.png)

