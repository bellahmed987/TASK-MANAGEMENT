import React from 'react'
import { NavLink } from 'react-router-dom'

function header() {
  
  return (
    <div className="header">
       <NavLink to={"/"} className="regester">TODO MANAGEMENT APPLICATION</NavLink>
      <div>
      <NavLink to={"/login"} className="regester">LOGIN</NavLink>
      <NavLink to={"/regester"} className="regester">REGESTER</NavLink>
      </div>
    </div>
  )
}

export default header