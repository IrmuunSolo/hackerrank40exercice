# Is This a Binary Search Tree

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/is-binary-search-tree/problem?isFullScreen=true)

## Бодлогын тайлбар

Энэхүү бодлогын зорилгоор бид хоёртын хайлтын модыг (binary search tree) дараах шаардлагын дагуу тодорхойлно:

- Нодны зүүн дэд модны (left subtree) бүх нодуудын утга тухайн нодны утгаас бага байх.

- Нодны баруун дэд модны (right subtree) бүх нодуудын утга тухайн нодны утгаас их байх.

Хоёртын модны root (эх) нод өгөгдсөн үед, энэ нь хоёртын хайлтын мод мөн эсэхийг тодорхойлно уу?

Доорх функцийг гүйцээн бөглөнө үү. Функц нь 1 параметртэй: хоёртын модны root нодыг заах хаяг (pointer). Функц нь тухайн мод хоёртын хайлтын мод эсэхийг илтгэх boolean утгыг буцаана. Энэ бодлогыг гүйцэтгэхийн тулд нэмэлт туслах функц бичих шаардлагатай байж болно.

**Оролтын формат:**

Та stdin-ээс ямар нэг оролт унших шаардлагагүй. Давхардсан код нь хоёртын модыг бүтээж, root нодыг функцийн аргумент болгон дамжуулах болно.

**Хязгаарлалт:**

• Нодны утга: 0 < data ≤ 10^4

**Гаралтын формат:**

Та stdout-руу ямар нэг гаралт хэвлэх шаардлагагүй. Хэрэв мод нь хоёртын хайлтын мод бол true, эсрэг тохиолдолд false буцаана. Давхардсан код нь энэ хариуг "Yes" эсвэл "No" гэж шинэ мөрөнд хэвлэнэ.

Жишээ оролт (stdin):

```
2
1 2 3 4 5 6 7
```

Хүлээгдэж буй гаралт:

```
Yes
```

## Бодолт:

Энэхүү бодлогын гол зорилго нь өгөгдсөн хоёртын мод нь хоёртын хайлтын мод (BST) эсэхийг шалгах юм. BST-ийн гол шинж нь:

1. Нодны зүүн дэд модны бүх утгууд тухайн нодны утгаас бага.

2. Нодны баруун дэд модны бүх утгууд тухайн нодны утгаас их.

```
    public static boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }
```

Үүнийг шалгахын тулд рекурсив аргаар модыг нэвтэрч, нод бүрийн утга өмнөх болон дараагийн утгуудын хооронд байгаа эсэхийг шалгана.

1. Нод бүрийн хувьд түүний зөвшөөрөгдөх утгын муж (min, max) тодорхойлно.

  - Зүүн дэд модны хувьд max утга нь эцэг нодын утгаас бага.

  - Баруун дэд модны хувьд min утга нь эцэг нодын утгаас их.

2. Хэрэв ямар нэг нод өөрийн мужын гадна байвал мод BST биш.

```
        Node root = null;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (root == null) {
                root = newNode;
            } else {
                Node parent = queue.peek();
                if (parent.left == null) {
                    parent.left = newNode;
                } else {
                    parent.right = newNode;
                    queue.poll();
                }
            }
            queue.add(newNode);
        }
        System.out.println(checkBST(root) ? "Yes" : "No");
```

## Submit screenshot

![Submit](/images/35.submit.png)

