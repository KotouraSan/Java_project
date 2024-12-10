import React from "react";
import { Route, Routes } from "react-router-dom";
import HomePage from "../Pages/HomePage/HomePage";
import CatalogPage from "../Pages/Catalog/CatalogPage";
import BuyPage from "../Pages/BuyPage/BuyPage";
import Layout from "./AppLayout";
import ProductCatalogPage from "../Pages/Catalog/ProductCatalogPage";
import ProfilePage from "../Pages/Profile/ProfilePage";

const AppRoutes = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<HomePage />} />
          <Route path="catalog" element={<CatalogPage />} />
          <Route path="catalog/:name" element={<ProductCatalogPage />} />

          <Route path="buy" element={<BuyPage />} />
          <Route path="profile" element={<ProfilePage />} />
        </Route>
      </Routes>
    </>
  );
};

export default AppRoutes;
