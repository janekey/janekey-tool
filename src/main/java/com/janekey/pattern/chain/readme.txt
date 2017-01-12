责任链模式：一个请求沿着一条"链"传递，直到该"链"上的某个处理者处理它为止。

有个基础的Handler抽象类，Handler有个handleRequest处理方法，一组Handler的实现类来组成这个"链"，
这些Handler实现类依次连接在一起(通过每个Handler类中的next Handler来实现链式结构)。
调用的时候从第一个Handler开始，知道真正处理的Handler来处理完成。