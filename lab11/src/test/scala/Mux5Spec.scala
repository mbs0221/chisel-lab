import chisel3.iotesters.PeekPokeTester
import org.scalatest._

class Mux5Test(dut: Mux5) extends PeekPokeTester(dut) {

  for (n <- 0 to 15) {
    for (sel <- 0 to 4) {
      poke(dut.io.a, n & 0x1)
      poke(dut.io.b, (n >> 1) & 0x1)
      poke(dut.io.c, (n >> 2) & 0x1)
      poke(dut.io.d, (n >> 3) & 0x1)
      poke(dut.io.e, (n >> 4) & 0x1)
      poke(dut.io.sel, sel)
      step(1)

      val res = (n >> sel) & 0x1

      // println(n + " " + sel + " " + res)
      expect(dut.io.y, res)
    }
  }
}

class Mux5Spec extends FlatSpec with Matchers {
  "Mux5 " should "pass" in {
    chisel3.iotesters.Driver(() => new Mux5) { c => new Mux5Test(c) } should be(true)
  }
}
