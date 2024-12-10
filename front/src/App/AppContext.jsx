import React, { createContext, useState } from "react";

export const AppContext = createContext();

export const AppProvider = ({ children }) => {
  const [items, setItems] = useState([]);
  return (
    <AppContext.Provider value={{ items, setItems }}>
      {children}
    </AppContext.Provider>
  );
};
