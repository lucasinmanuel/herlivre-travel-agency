import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View, Button } from "react-native";
import { useEffect, useState } from "react";
import {
  getCargo,
  getCidade,
  getComprovante,
  getHotel,
  getPacote,
  getQuarto,
  getRegistroAluguelQuarto,
  getUsuario,
  getVoo,
} from "./Herlivre_api";

export default function App() {
  const [herlivre_api, setHerlivre_api] = useState([]);

  async function api(get) {
    if (get === "cargo") {
      getCargo().then((result) => {
        setHerlivre_api([get, result]);
      });
    } else if (get === "cidade") {
      getCidade().then((result) => {
        setHerlivre_api([get, result]);
      });
    } else if (get === "comprovante") {
      getComprovante().then((result) => {
        setHerlivre_api([get, result]);
      });
    } else if (get === "hotel") {
      getHotel().then((result) => {
        setHerlivre_api([get, result]);
      });
    } else if (get === "pacote") {
      getPacote().then((result) => {
        setHerlivre_api([get, result]);
      });
    } else if (get === "quarto") {
      getQuarto().then((result) => {
        setHerlivre_api([get, result]);
      });
    } else if (get === "registroAluguelQuarto") {
      getRegistroAluguelQuarto().then((result) => {
        setHerlivre_api([get, result]);
      });
    } else if (get === "usuario") {
      getUsuario().then((result) => {
        setHerlivre_api([get, result]);
      });
    } else if (get === "voo") {
      getVoo().then((result) => {
        setHerlivre_api([get, result]);
      });
    }
    console.log(herlivre_api);
  }

  return (
    <View style={styles.container}>
      <div style={styles.buttons_wrapper}>
        <Button
          title="Get Cargos"
          onPress={() => {
            api("cargo");
          }}
        />
        <div style={styles.sizing_15}></div>
        <Button
          title="Get Cidades"
          onPress={() => {
            api("cidade");
          }}
        />
        <div style={styles.sizing_15}></div>
        <Button
          title="Get Comprovantes"
          onPress={() => {
            api("comprovante");
          }}
        />
        <div style={styles.sizing_15}></div>
        <Button
          title="Get hotéis"
          onPress={() => {
            api("hotel");
          }}
        />
        <div style={styles.sizing_15}></div>
        <Button
          title="Get Pacotes"
          onPress={() => {
            api("pacote");
          }}
        />
        <div style={styles.sizing_15}></div>
        <Button
          title="Get Quartos"
          onPress={() => {
            api("quarto");
          }}
        />
        <div style={styles.sizing_15}></div>
        <Button
          title="Get Registro de Aluguel dos Quartos"
          onPress={() => {
            api("registroAluguelQuarto");
          }}
        />
        <div style={styles.sizing_15}></div>
        <Button
          title="Get Usuários"
          onPress={() => {
            api("usuario");
          }}
        />
        <div style={styles.sizing_15}></div>
        <Button
          title="Get Voos"
          onPress={() => {
            api("voo");
          }}
        />
      </div>
      {herlivre_api[0] === "cargo" && (
        <table style={styles.table}>
          <thead>
            <tr style={styles.tr}>
              <td style={styles.td_head}>Id</td>
              <td style={styles.td_head}>Cargo</td>
            </tr>
          </thead>
          {herlivre_api[1].map((cargo) => {
            return (
              <tbody key={cargo.id}>
                <tr style={styles.tr}>
                  <td style={styles.td_body}>{cargo.id}</td>
                  <td style={styles.td_body}>{cargo.nome}</td>
                </tr>
              </tbody>
            );
          })}
        </table>
      )}

      {herlivre_api[0] === "cidade" && (
        <table style={styles.table}>
          <thead>
            <tr style={styles.tr}>
              <td style={styles.td_head}>Id</td>
              <td style={styles.td_head}>Nome</td>
              <td style={styles.td_head}>Estado</td>
              <td style={styles.td_head}>País</td>
              <td style={styles.td_head}>Continente</td>
            </tr>
          </thead>
          {herlivre_api[1].map((cidade) => {
            return (
              <tbody key={cidade.id}>
                <tr style={styles.tr}>
                  <td style={styles.td_body}>{cidade.id}</td>
                  <td style={styles.td_body}>{cidade.nome}</td>
                  <td style={styles.td_body}>{cidade.uf}</td>
                  <td style={styles.td_body}>{cidade.pais}</td>
                  <td style={styles.td_body}>{cidade.continente}</td>
                </tr>
              </tbody>
            );
          })}
        </table>
      )}

      {herlivre_api[0] === "comprovante" && (
        <table style={styles.table}>
          <thead>
            <tr style={styles.tr}>
              <td style={styles.td_head}>Id</td>
              <td style={styles.td_head}>
                Id do registro de aluguel do quarto
              </td>
              <td style={styles.td_head}>Id do usuário</td>
              <td style={styles.td_head}>Id do pacote</td>
              <td style={styles.td_head}>Data da compra</td>
            </tr>
          </thead>
          {herlivre_api[1].map((comprovante) => {
            return (
              <tbody key={comprovante.id}>
                <tr style={styles.tr}>
                  <td style={styles.td_body}>{comprovante.id}</td>
                  <td style={styles.td_body}>
                    {comprovante.registroAluguelQuarto}
                  </td>
                  <td style={styles.td_body}>{comprovante.usuario}</td>
                  <td style={styles.td_body}>{comprovante.pacote}</td>
                  <td style={styles.td_body}>{comprovante.data_compra}</td>
                </tr>
              </tbody>
            );
          })}
        </table>
      )}
      {herlivre_api[0] === "hotel" && (
        <table style={styles.table}>
          <thead>
            <tr style={styles.tr}>
              <td style={styles.td_head}>Id</td>
              <td style={styles.td_head}>Id da cidade</td>
              <td style={styles.td_head}>Nome</td>
              <td style={styles.td_head}>Quantidade de estrelas</td>
              <td style={styles.td_head}>Valor mínimo</td>
              <td style={styles.td_head}>Wifi</td>
              <td style={styles.td_head}>Café da manhã</td>
              <td style={styles.td_head}>CEP</td>
              <td style={styles.td_head}>Logradouro</td>
              <td style={styles.td_head}>Bairro</td>
            </tr>
          </thead>
          {herlivre_api[1].map((hotel) => {
            return (
              <tbody key={hotel.id}>
                <tr style={styles.tr}>
                  <td style={styles.td_body}>{hotel.id}</td>
                  <td style={styles.td_body}>{hotel.cidade}</td>
                  <td style={styles.td_body}>{hotel.nome}</td>
                  <td style={styles.td_body}>{hotel.qtd_estrelas}</td>
                  <td style={styles.td_body}>{hotel.valor_min}</td>
                  <td style={styles.td_body}>{hotel.wifi}</td>
                  <td style={styles.td_body}>{hotel.cafe_manha}</td>
                  <td style={styles.td_body}>{hotel.cep}</td>
                  <td style={styles.td_body}>{hotel.logradouro}</td>
                  <td style={styles.td_body}>{hotel.bairro}</td>
                </tr>
              </tbody>
            );
          })}
        </table>
      )}
      {herlivre_api[0] === "pacote" && (
        <table style={styles.table}>
          <thead>
            <tr style={styles.tr}>
              <td style={styles.td_head}>Id</td>
              <td style={styles.td_head}>Id do voo 1</td>
              <td style={styles.td_head}>Id do voo 2</td>
              <td style={styles.td_head}>
                Id do registro de aluguel do quarto
              </td>
              <td style={styles.td_head}>Total de pessoas</td>
              <td style={styles.td_head}>Valor original</td>
              <td style={styles.td_head}>Desconto</td>
              <td style={styles.td_head}>Valor promocional</td>
            </tr>
          </thead>
          {herlivre_api[1].map((pacote) => {
            return (
              <tbody key={pacote.id}>
                <tr style={styles.tr}>
                  <td style={styles.td_body}>{pacote.id}</td>
                  <td style={styles.td_body}>{pacote.voo_1}</td>
                  <td style={styles.td_body}>{pacote.voo_2}</td>
                  <td style={styles.td_body}>
                    {pacote.registroAluguelQuarto.id}
                  </td>
                  <td style={styles.td_body}>{pacote.total_pessoas}</td>
                  <td style={styles.td_body}>{pacote.valor_original}</td>
                  <td style={styles.td_body}>{pacote.desconto}</td>
                  <td style={styles.td_body}>{pacote.valor_promocional}</td>
                </tr>
              </tbody>
            );
          })}
        </table>
      )}
      {herlivre_api[0] === "quarto" && (
        <table style={styles.table}>
          <thead>
            <tr style={styles.tr}>
              <td style={styles.td_head}>Id</td>
              <td style={styles.td_head}>Id do hotel</td>
              <td style={styles.td_head}>Número</td>
              <td style={styles.td_head}>Valor</td>
              <td style={styles.td_head}>Diária</td>
              <td style={styles.td_head}>Quantidade de camas</td>
              <td style={styles.td_head}>Tipo</td>
            </tr>
          </thead>
          {herlivre_api[1].map((quarto) => {
            return (
              <tbody key={quarto.id}>
                <tr style={styles.tr}>
                  <td style={styles.td_body}>{quarto.id}</td>
                  <td style={styles.td_body}>{quarto.hotel}</td>
                  <td style={styles.td_body}>{quarto.numero}</td>
                  <td style={styles.td_body}>{quarto.valor}</td>
                  <td style={styles.td_body}>{quarto.diaria}</td>
                  <td style={styles.td_body}>{quarto.qtd_camas}</td>
                  <td style={styles.td_body}>{quarto.tipo}</td>
                </tr>
              </tbody>
            );
          })}
        </table>
      )}
      {herlivre_api[0] === "registroAluguelQuarto" && (
        <table style={styles.table}>
          <thead>
            <tr style={styles.tr}>
              <td style={styles.td_head}>Id</td>
              <td style={styles.td_head}>Id do quarto</td>
              <td style={styles.td_head}>Data de entrada</td>
              <td style={styles.td_head}>Data de saída</td>
            </tr>
          </thead>
          {herlivre_api[1].map((registroAluguelQuarto) => {
            return (
              <tbody key={registroAluguelQuarto.id}>
                <tr style={styles.tr}>
                  <td style={styles.td_body}>{registroAluguelQuarto.id}</td>
                  <td style={styles.td_body}>{registroAluguelQuarto.quarto}</td>
                  <td style={styles.td_body}>
                    {registroAluguelQuarto.data_entrada}
                  </td>
                  <td style={styles.td_body}>
                    {registroAluguelQuarto.data_saida}
                  </td>
                </tr>
              </tbody>
            );
          })}
        </table>
      )}
      {herlivre_api[0] === "usuario" && (
        <table style={styles.table}>
          <thead>
            <tr style={styles.tr}>
              <td style={styles.td_head}>Id</td>
              <td style={styles.td_head}>Id do cargo</td>
              <td style={styles.td_head}>Nome</td>
              <td style={styles.td_head}>CPF</td>
              <td style={styles.td_head}>E-mail</td>
              <td style={styles.td_head}>Password</td>
            </tr>
          </thead>
          {herlivre_api[1].map((usuario) => {
            return (
              <tbody key={usuario.id}>
                <tr style={styles.tr}>
                  <td style={styles.td_body}>{usuario.id}</td>
                  <td style={styles.td_body}>{usuario.cargo}</td>
                  <td style={styles.td_body}>{usuario.nome}</td>
                  <td style={styles.td_body}>{usuario.cpf}</td>
                  <td style={styles.td_body}>{usuario.email}</td>
                  <td style={styles.td_body}>{usuario.password}</td>
                </tr>
              </tbody>
            );
          })}
        </table>
      )}
      {herlivre_api[0] === "voo" && (
        <table style={styles.table}>
          <thead>
            <tr style={styles.tr}>
              <td style={styles.td_head}>Id</td>
              <td style={styles.td_head}>Id da cidade</td>
              <td style={styles.td_head}>Local de partida</td>
              <td style={styles.td_head}>Companhia</td>
              <td style={styles.td_head}>Número do voo</td>
              <td style={styles.td_head}>Número do assento</td>
              <td style={styles.td_head}>Quantidade de assentos disponíveis</td>
              <td style={styles.td_head}>Data de partida</td>
              <td style={styles.td_head}>Data de chegada</td>
            </tr>
          </thead>
          {herlivre_api[1].map((voo) => {
            return (
              <tbody key={voo.id}>
                <tr style={styles.tr}>
                  <td style={styles.td_body}>{voo.id}</td>
                  <td style={styles.td_body}>{voo.cidade}</td>
                  <td style={styles.td_body}>{voo.local_partida}</td>
                  <td style={styles.td_body}>{voo.companhia}</td>
                  <td style={styles.td_body}>{voo.num_voo}</td>
                  <td style={styles.td_body}>{voo.num_assento}</td>
                  <td style={styles.td_body}>{voo.qtd_assentos_disp}</td>
                  <td style={styles.td_body}>{voo.data_partida}</td>
                  <td style={styles.td_body}>{voo.data_chegada}</td>
                </tr>
              </tbody>
            );
          })}
        </table>
      )}
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
  buttons_wrapper: {
    display: "flex",
  },
  sizing_15: {
    width: "15px",
  },
  tr: {
    borderWidth: "1px",
    borderColor: "black",
    borderStyle: "solid",
  },
  td_head: {
    padding: "10px",
    borderWidth: "1px",
    borderColor: "black",
    borderStyle: "solid",
    fontSize: "18px",
    fontWeight: "bold",
  },
  td_body: {
    padding: "10px",
    borderWidth: "1px",
    borderColor: "black",
    borderStyle: "solid",
    fontSize: "18px",
  },
  table: {
    borderWidth: "1px",
    borderColor: "black",
    borderStyle: "solid",
    borderCollapse: "collapse",
    marginTop: "10px",
    textAlign: "center",
  },
});
