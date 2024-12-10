import { useContext } from "react";
import { Link, Outlet } from "react-router-dom";
import { AppContext } from "./AppContext";
const Layout = () => {
  const { items } = useContext(AppContext);
  return (
    <>
      <header>
        <div className="logo">
          <Link to="/">
            <h1>WholeProducts</h1>
          </Link>

          <Link to="/catalog">
            <p>Каталог</p>
          </Link>
        </div>
        <ul>
          <Link to="/profile">
            <li className="profile_header">
              <img alt="" src="/images/user.svg" />
              <p>Профиль</p>
            </li>
          </Link>
          <Link to="/buy">
            <li>
              <img alt="" src="/images/purchase.svg" />
              <p>{items.length}</p>
            </li>
          </Link>
        </ul>
      </header>
      <Outlet />
    </>
  );
};
export default Layout;
