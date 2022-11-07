export const getCargo = async () => {
    const response = await fetch("https://localhost:7116/api/Cargo", {
        method: "GET",
    })
    const data = await response.json();
    return data;
}

export const getCidade = async () => {
    const response = await fetch("https://localhost:7116/api/Cidade", {
        method: "GET",
    })
    const data = await response.json();
    return data;
}

export const getComprovante = async () => {
    const response = await fetch("https://localhost:7116/api/Comprovante", {
        method: "GET",
    })
    const data = await response.json();
    return data;
}

export const getHotel = async () => {
    const response = await fetch("https://localhost:7116/api/Hotel", {
        method: "GET",
    })
    const data = await response.json();
    return data;
}

export const getPacote = async () => {
    const response = await fetch("https://localhost:7116/api/Pacote", {
        method: "GET",
    })
    const data = await response.json();
    return data;
}

export const getQuarto = async () => {
    const response = await fetch("https://localhost:7116/api/Quarto", {
        method: "GET",
    })
    const data = await response.json();
    return data;
}

export const getRegistroAluguelQuarto = async () => {
    const response = await fetch("https://localhost:7116/api/RegistroAluguelQuarto", {
        method: "GET",
    })
    const data = await response.json();
    return data;
}

export const getUsuario = async () => {
    const response = await fetch("https://localhost:7116/api/Usuario", {
        method: "GET",
    })
    const data = await response.json();
    return data;
}

export const getVoo = async () => {
    const response = await fetch("https://localhost:7116/api/Voo", {
        method: "GET",
    })
    const data = await response.json();
    return data;
}