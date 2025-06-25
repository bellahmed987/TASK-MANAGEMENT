import React, { Children } from 'react'
import Header from './header'
import Footer from './footer'
import { Outlet } from 'react-router-dom'
function applayout() {
  return (
    <>
    <Header/>
    <Outlet/>
    <Footer/>
    </>
    
  )
}

export default applayout