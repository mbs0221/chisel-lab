import chisel3._
import chisel3.util._
import scala.annotation.switch

class SevenSegDecoder extends Module {
  val io = IO(new Bundle {
    val sw = Input(UInt(4.W))
    val seg = Output(UInt(7.W))
    val an = Output(UInt(4.W))
  })

  val sevSeg = WireInit(0.U)

  // ***** your code starts here *****
  switch (io.sw) {
    is(0.U) { io.seg := "b1111110".U }
    is(1.U) { io.seg := "b0110000".U }
    is(2.U) { io.seg := "b1101101".U }
    is(3.U) { io.seg := "b1111001".U }
    is(4.U) { io.seg := "b0110011".U }
    is(5.U) { io.seg := "b1011011".U }
    is(6.U) { io.seg := "b1011111".U }
    is(7.U) { io.seg := "b1110000".U }
    is(8.U) { io.seg := "b1111111".U }
    is(9.U) { io.seg := "b1111011".U }    
  }
  // ***** your code ends here *****

  io.seg := ~sevSeg
  io.an := "b1110".U
}

// generate Verilog
object SevenSegDecoder extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new SevenSegDecoder())

}


