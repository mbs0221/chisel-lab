import chisel3._
import chisel3.util._

class CountSevenSeg extends Module {
  val io = IO(new Bundle {
    val seg = Output(UInt(7.W))
    val an = Output(UInt(4.W))
  })

  val sevSeg = WireInit("b1111111".U(7.W))

  // *** your code starts here
  // counter
  val num = RegInit(0.U(4.W))
  num := num + 1.U
  // divider
  val counter = RegInit(500000.U)
  counter := counter - 1.U
  when (counter === 0.U) {
    counter := 500000.U
  }
  // decoder
  val decoder = Module(new SevenSegDec())
  decoder.io.in := num
  io.seg := decoder.io.out

  // *** your code ends here

  io.seg := ~sevSeg
  io.an := "b1110".U
}

// generate Verilog
object CountSevenSeg extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new CountSevenSeg())
}