import React, { useState, useEffect } from "react";
import { urlPort } from "../../constants";
import "./styles.css";
import { Link } from "react-router-dom";
const CatalogPage = () => {
  const [formData, setFormData] = useState({
    shopDistrict: "",
    shopCity: "",
    shopRating: "",
  });
  const [data, setData] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSearch = async () => {
    const isAllEmpty =
      !formData.shopDistrict && !formData.shopCity && !formData.shopRating;
    const endpoint = isAllEmpty
      ? `${urlPort}shop/`
      : `${urlPort}shop/f/?${new URLSearchParams({
          ...(formData.shopDistrict && { shopDistrict: formData.shopDistrict }),
          ...(formData.shopCity && { shopCity: formData.shopCity }),
          ...(formData.shopRating && { shopRating: formData.shopRating }),
        }).toString()}`;

    try {
      const response = await fetch(endpoint);
      if (!response.ok) {
        throw new Error("Ошибка при загрузке данных");
      }
      const result = await response.json();
      console.log(result);
      setData(result);
    } catch (error) {
      console.error("Ошибка:", error);
      setData(null);
    }
  };

  useEffect(() => {
    handleSearch();
  }, []);

  const districts = [
    { id: 1, name: "Юнусабадский район" },
    { id: 2, name: "Мирзо Улугбекский район" },
    { id: 3, name: "Шайхантахурский район" },
    { id: 4, name: "Алмазарский район" },
    { id: 5, name: "Бектемирский район" },
    { id: 6, name: "Мирабадский район" },
    { id: 7, name: "Сергелийский район" },
    { id: 8, name: "Чиланзарский район" },
    { id: 9, name: "Яккасарайский район" },
    { id: 10, name: "Яшнабадский район" },
    { id: 11, name: "Учтепинский район" },
  ];
  const citys = [
    { id: 1, name: "Tashkent" },
    { id: 2, name: "Samarkand" },
    { id: 3, name: "Bukhara" },
    { id: 4, name: "Fergana" },
  ];

  const handleClear = () => {
    setFormData({
      shopDistrict: "",
      shopCity: "",
      shopRating: "",
    });
    handleSearch();
  };

  return (
    <div className="catalog_page">
      <aside className="catalog_filter">
        <h1>Фильтры</h1>
        <select
          name="shopDistrict"
          value={formData.shopDistrict}
          onChange={handleChange}
        >
          <option value="">Select a district</option>
          {districts.map((company) => (
            <option key={company.id} value={company.id}>
              {company.name}
            </option>
          ))}
        </select>
        <select
          name="shopCity"
          value={formData.shopCity}
          onChange={handleChange}
        >
          <option value="">Select a city</option>
          {citys.map((company) => (
            <option key={company.id} value={company.name}>
              {company.name}
            </option>
          ))}
        </select>
        <input
          type="number"
          name="shopRating"
          value={formData.shopRating}
          onChange={handleChange}
          placeholder="Enter shop rating"
        />
        <div className="aside_buttons">
          <button onClick={handleClear}>Сбросить</button>
          <button onClick={handleSearch}>Поиск</button>
        </div>
      </aside>
      <div className="results">
        {data ? (
          <>
            <h1>Магазины</h1>
            <div className="catalog_company">
              {data.map((item) => (
                <Link to={`/catalog/${item.shopName}`}>
                  <div className={`catalog_company_item shop-${item.shopId}`}>
                    <h1>{item.shopName}</h1>
                    <p>{item.shopCity}</p>
                    <p>{item.shopAddress}</p>

                    <p>{item.shopEmailAddress}</p>
                    <p>{item.shopPhoneNumber}</p>
                    <p>{item.shopRating}</p>
                  </div>
                </Link>
              ))}
            </div>
          </>
        ) : (
          <p>Нет результатов</p>
        )}
      </div>
    </div>
  );
};

export default CatalogPage;
