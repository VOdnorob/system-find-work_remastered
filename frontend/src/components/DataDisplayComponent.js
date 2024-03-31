import React, { useState, useEffect } from 'react';
import { fetchData } from '../services/api';

function DataDisplayComponent() {
    const [data, setData] = useState([]);

    useEffect(() => {
        fetchData().then(data => setData(data));
    }, []);

    return (
        <div>
            {data.map((item, index) => (
                <div key={index}>{item.name}</div> // Адаптуй цей рядок під структуру твоїх даних
            ))}
        </div>
    );
}

export default DataDisplayComponent;