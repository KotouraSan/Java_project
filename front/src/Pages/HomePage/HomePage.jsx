import React, { useEffect, useState } from "react";
import "./styles.css";
import { urlPort } from "../../constants";
import { Link } from "react-router-dom";
const HomePage = () => {
  const [data, setData] = useState(null);
  const [products, setProducts] = useState(null);
  const [products2, setProducts2] = useState(null);
  const [products3, setProducts3] = useState(null);
  const fetchCompanies = async () => {
    const url = `${urlPort}shop/`;
    const response = await fetch(url);

    if (!response.ok) {
      throw new Error(`Error: ${response.status}`);
    }

    const result = await response.json();
    console.log(result);
    setData(result);
  };

  const fetchProducts = async () => {
    const url = `${urlPort}shop/products/makro`;
    const response = await fetch(url);

    if (!response.ok) {
      throw new Error(`Error: ${response.status}`);
    }

    const result = await response.json();
    console.log(result);
    setProducts(result);
  };
  const fetchProducts2 = async () => {
    const url = `${urlPort}shop/products/korzinka`;
    const response = await fetch(url);

    if (!response.ok) {
      throw new Error(`Error: ${response.status}`);
    }

    const result = await response.json();
    console.log(result);
    setProducts2(result);
  };
  const fetchProducts3 = async () => {
    const url = `${urlPort}shop/products/galmart`;
    const response = await fetch(url);

    if (!response.ok) {
      throw new Error(`Error: ${response.status}`);
    }

    const result = await response.json();
    console.log(result);
    setProducts3(result);
  };

  useEffect(() => {
    fetchCompanies();
    fetchProducts();
    fetchProducts2();
    fetchProducts3();
  }, []);

  if (!data || !products || !products2 || !products3) {
    return <div>Loading</div>;
  }

  return (
    <div className="home_page">
      <div className="home_page_banner">
        <div>
          <h1>Покупай лучшие товары по самым выгодным ценам!</h1>
          <h2>
            Переходи в каталог и заказывай доставку в любую точку Ташкента
          </h2>
        </div>
        <img alt="" src="/images/meat.png" />
      </div>
      <div className="home_page_catalog">
        <h1>Магазины</h1>
        <div className="home_page_container">
          {data.map((item) => (
            <Link to={`/catalog/${item.shopName}`}>
              <div className={`shop-${item.shopId}`}>{item.shopName}</div>
            </Link>
          ))}
        </div>
      </div>
      <div className="home_page_catalog">
        <h1>Продукты</h1>
        <div className="home_page_container">
          {products.map((item) => (
            <Link to={`/catalog/Makro`}>
              <div
                className={`home_page_product`}
                style={{
                  background: `linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)), url(${item.productUrl})`,
                  backgroundSize: "cover",
                  backgroundPosition: "center",
                  color: "white",
                  display: "flex",
                  alignItems: "center",
                  justifyContent: "center",
                  textAlign: "center",
                }}
              >
                {item.productName}
              </div>
            </Link>
          ))}
          {products2.map((item) => (
            <Link to={`/catalog/Korzinka`}>
              <div
                className={`home_page_product`}
                style={{
                  background: `linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)), url(${item.productUrl})`,
                  backgroundSize: "cover",
                  backgroundPosition: "center",
                  color: "white",
                  display: "flex",
                  alignItems: "center",
                  justifyContent: "center",
                  textAlign: "center",
                }}
              >
                {item.productName}
              </div>
            </Link>
          ))}
          {products3.map((item) => (
            <Link to={`/catalog/Galmart`}>
              <div
                className={`home_page_product`}
                style={{
                  background: `linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)), url(${item.productUrl})`,
                  backgroundSize: "cover",
                  backgroundPosition: "center",
                  color: "white",
                  display: "flex",
                  alignItems: "center",
                  justifyContent: "center",
                  textAlign: "center",
                }}
              >
                {item.productName}
              </div>
            </Link>
          ))}
        </div>
      </div>
    </div>
  );
};
export default HomePage;
