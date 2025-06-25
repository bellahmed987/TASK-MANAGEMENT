import React from 'react'
import { useNavigate } from 'react-router-dom'

function header() {
  const navigate=useNavigate()
  return (
    <div className="header">
      <h1  onClick={()=>navigate("/")}>TODO MANAGEMENT APPLICATION</h1>
    </div>
  )
}

export default header