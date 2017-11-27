class Room(val capacity:Int, val supportsVideo: Boolean, val supportsSpotlight: Boolean, val supportsPanel: Boolean) {
  override def toString = s"Room with capacity $capacity"

  def satisfies(session: Session):Boolean = {
    (capacity >= session.numPersons) &&
      (supportsVideo || !session.needsVideo) &&
      (supportsSpotlight || !session.needsSpotlight) &&
      (supportsPanel || !session.needsPanel)
  }
}

case class Session(val numPersons:Int, val needsVideo: Boolean, val needsSpotlight: Boolean, val needsPanel: Boolean){
  private var a = 5;

  def ana = a;
  def ana_= (aval: Int):Unit = a = aval

  def satisfiedBy(room: Room) = room.satisfies(this)

  override def toString: String = s"Session with $numPersons people"
}

object Scheduler{
  def main(args: Array[String]): Unit = {
    var a = Session(42, true, false, false)
    var b = Session(42, true, false, false)

    val sessions:Array[Session] = Array(
      Session(42, true, false, false),
      Session(47, true, true, true),
    )

    println(a == b)
  }


}