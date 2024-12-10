import React, { useContext } from "react";
import { AppContext } from "../../App/AppContext";
import "./styles.css";
import { Link } from "react-router-dom";

const BuyPage = () => {
  const { items, setItems } = useContext(AppContext);
  const token = localStorage.getItem("token");

  const handleDeleteItem = (id) => {
    const updatedItems = items.filter((item) => item.id !== id);
    setItems(updatedItems);
  };

  return (
    <div className="buy_page">
      <div className="buy_items">
        <h1>Ваша корзина</h1>
        <div className="buy_items_store">
          {items.length !== 0 ? (
            <>
              {items.map((item) => (
                <div className="buy_item" key={item.id}>
                  <img alt="" src={item.productUrl} />
                  <div className="buy_item_info">
                    <div>
                      <h1>{item.productName}</h1>
                      <p>{item.productDescription}</p>
                    </div>
                    <div className="buy_item_prices">
                      <h6>{item.productPrice} сум</h6>
                      <button onClick={() => handleDeleteItem(item.id)}>
                        Удалить
                      </button>
                    </div>
                  </div>
                </div>
              ))}
            </>
          ) : (
            <div>Корзина пустая</div>
          )}
        </div>
      </div>
      <div className="purchase">
        {token ? (
          <div className="make_login">
            <h1>Авторизуйтесь</h1>
            <Link to="/profile">
              <button>Перейти</button>
            </Link>
          </div>
        ) : (
          <div className="make_login">
            <button>Оформить заказ</button>
          </div>
        )}
      </div>
    </div>
  );
};

export default BuyPage;
