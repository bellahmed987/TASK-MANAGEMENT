import React from 'react'
import { NavLink, useNavigate } from 'react-router-dom'
import { islogin, logout } from '../service/authservice'

function Header() {
  const navigate = useNavigate();
  const isAuth = islogin();

  function handleLogout() {
    logout();
    navigate("/");
  }

  return (
    <div className="header">
      <NavLink to="/todo" className="regester">
        TODO MANAGEMENT APPLICATION
      </NavLink>

      {!isAuth && (
        <div>
          <NavLink to="/login" className="regester">LOGIN</NavLink>
          <NavLink to="/regester" className="regester">REGISTER</NavLink>
        </div>
      )}

      {isAuth && (
        <div>
          <button className="regester" onClick={handleLogout}>LOGOUT</button>
        </div>
      )}
    </div>
  )
}

export default Header
