import React, { useContext, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { urlPort } from "../../constants";
import { AppContext } from "../../App/AppContext";
const ProductCatalogPage = () => {
  const { name } = useParams();
  const { setItems } = useContext(AppContext);
  const [products, setProducts] = useState(null);
  const fetchProducts = async () => {
    const url = `${urlPort}shop/products/${name}`;
    const response = await fetch(url);

    if (!response.ok) {
      throw new Error(`Error: ${response.status}`);
    }

    const result = await response.json();
    console.log(result);
    setProducts(result);
  };
  useEffect(() => {
    fetchProducts();
  }, []);
  if (!products) return <div>Loading</div>;
  return (
    <div className="product_catalog_page">
      <h1>Продукты магазина {name}</h1>
      <div className="product_catalog">
        {products.map((item) => (
          <div className="product_catalog_item">
            <img alt="" src={item.productUrl} />
            <div>
              <div>
                <h1>{item.productName}</h1>
                <p>{item.productDescription}</p>
              </div>
              <div>
                <h5>{item.stock} осталось</h5>
                <h6>{item.productPrice}</h6>
              </div>
            </div>
            <button
              className="product_catalog_button"
              onClick={() => setItems((prevItems) => [...prevItems, item])}
            >
              Купить
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};
export default ProductCatalogPage;
