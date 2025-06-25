import './App.css'
import {  RouterProvider, createBrowserRouter } from 'react-router-dom'
import Applayout from './components/applayout'
import Listtodo from './components/listtodo'
import Addtodo from './components/addtodo'
import { gettodoall } from './service/service'
function App() {
const router=createBrowserRouter([
  {
path:"/",
element:<Applayout/>,
children:[
  {path:"/",
  element:<Listtodo/>,
  loader:gettodoall,

  },{
    path:"/addtodo",
    element:<Addtodo/>

  }
  ,{
    path:"/updatetodo/:id",
    element:<Addtodo/>
  }
]
  }
])

  return (
<RouterProvider router={router}/>
   )
}

export default App
