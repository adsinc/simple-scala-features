// Миксины

case class Room(description: String)

trait Strategy {
  def update(room: Room): Room = Room(room.description + " updated")
}

trait CompleteBuild extends Strategy {
  override def update(room: Room) = Room(super.update(room).description + " building completed")
}

trait ProductResources extends Strategy {
  override def update(room: Room) = Room(super.update(room).description + " resources produced")
}

trait ProduceSpells extends Strategy {
  override def update(room: Room) = Room(super.update(room).description + " spells produced")
}

val room = Room("Room")

val productionRoomStrategy = new Strategy with CompleteBuild with ProductResources
productionRoomStrategy.update(room)

val spellRoomStrategy = new Strategy with CompleteBuild with ProduceSpells
spellRoomStrategy.update(room)