case class Room(val capacity:Int, val supportsVideo: Boolean, val supportsSpotlight: Boolean, val supportsPanel: Boolean) {
//  override def toString = s"Room with capacity $capacity"


  def satisfies(session: Session):Boolean = {
    (capacity >= session.numPersons) &&
      (supportsVideo || !session.needsVideo) &&
      (supportsSpotlight || !session.needsSpotlight) &&
      (supportsPanel || !session.needsPanel)
  }
}

case class Session(val numPersons:Int, val needsVideo: Boolean, val needsSpotlight: Boolean, val needsPanel: Boolean){
  private var a = 5;

  def satisfiedBy(room: Room) = room.satisfies(this)

//  override def toString: String = s"Session with $numPersons people"
}

case class Pairing(val session: Session, val room: Room)

object Scheduler{
  def main(args: Array[String]): Unit = {
    var a = Session(42, true, false, false)
    var b = Session(42, true, false, false)

    val sessions:Array[Session] = Array(
      Session(42, true, false, false),
      Session(47, true, true, true),
      Session(15, true, false, false),
      Session(35, false, false, false),
      Session(54, true, false, true),
      Session(23, false, true, true)
    )

    val rooms:Array[Room] = Array(
      Room(62, true, true, true),
      Room(23, false, true, true),
      Room(67, false, false, false),
      Room(23, true, false, true),
      Room(75, true, true, false),
      Room(33, true, true, false),

    )
    println(Room(34,true,true,true).supportsPanel)


  }


}