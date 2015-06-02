package io.strongtyped.active.slick.dao

import io.strongtyped.active.slick.{JdbcProfileProvider, Identifiable}
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext


trait EntityDaoLike[M <: Identifiable] extends SlickDao[M] {

  val jdbcProfile:JdbcProfile

  import jdbcProfile.api._

  type Model <: M
  type Id <: M#Id

  def insert(model: M): DBIO[M#Id]

  def deleteById(id: M#Id)(implicit exc: ExecutionContext): DBIO[Int]

  def findById(id: M#Id): DBIO[M]

  def findOptionById(id: M#Id): DBIO[Option[M]]

}