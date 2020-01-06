package main

import (
	"fmt"
	"math"
)

// https://tour.go-zh.org/methods/1

type Vertex struct {
	X ,Y float64
}

// 在 func 与 方法名之间指定方法的接受者(这里是值接受者)，即该方法是哪个 struct 的方法
// 你只能为在同一包内定义的类型的接收者声明方法，而不能为其它包内定义的类型
// 若使用 值接受者， 则方法中操作的是接受者的一个副本，而非 接受者 本身。
func (v Vertex) Abs() float64 {
	return math.Sqrt(v.X * v.X  + v.Y * v.Y)
}

// https://tour.go-zh.org/methods/4
// 使用 指针接受者(加 * 号)，方法中操作的则是接受者本身。
// 如果去掉 * 号，则对接受者的赋值无效。
// 与 值接受者相比，这与 C 语言中的 值传递与引用传递很像。
func (v *Vertex) Scale(f float64) {
	v.X = v.X * f
	v.Y = v.Y * f
}

// 将 Scala 重写为函数
func ScaleFun(v * Vertex, f float64) {
	v.X = v.X * f
	v.Y = v.Y * f
}

func main() {
	v := Vertex{3, 4}
	fmt.Println("使用值接收者： ", v.Abs())
	v.Scale(10)
	fmt.Println("使用指针接收者",v)

	ScaleFun(&v, 10)
	fmt.Println("使用函数重写的指针接收者：", v)

	// 可以直接在指针上调用 方法。
	p := &v
	// Go 会将语句解释为 (&p).Scala(10)
	p.Scale(10)
	fmt.Println("在指针上调用方法：", *p)

}