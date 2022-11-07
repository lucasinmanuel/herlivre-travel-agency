using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Herlivre_api.Migrations
{
    public partial class inicial : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Cargo",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Nome = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Cargo", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Cidade",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Nome = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true),
                    Uf = table.Column<string>(type: "nvarchar(2)", maxLength: 2, nullable: true),
                    Pais = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true),
                    Continente = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Cidade", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Usuario",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    id_cargo = table.Column<long>(type: "bigint", nullable: true),
                    Nome = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true),
                    Cpf = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: true),
                    Email = table.Column<string>(type: "nvarchar(30)", maxLength: 30, nullable: true),
                    Password = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Usuario", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Usuario_Cargo_id_cargo",
                        column: x => x.id_cargo,
                        principalTable: "Cargo",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateTable(
                name: "Hotel",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    id_cidade = table.Column<long>(type: "bigint", nullable: true),
                    Nome = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true),
                    Qtd_estrelas = table.Column<int>(type: "int", maxLength: 5, nullable: false),
                    Valor_min = table.Column<double>(type: "float", nullable: false),
                    Wifi = table.Column<bool>(type: "bit", nullable: false),
                    Cafe_manha = table.Column<bool>(type: "bit", nullable: false),
                    Cep = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: true),
                    Logradouro = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true),
                    Bairro = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Hotel", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Hotel_Cidade_id_cidade",
                        column: x => x.id_cidade,
                        principalTable: "Cidade",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateTable(
                name: "Voo",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    id_cidade = table.Column<long>(type: "bigint", nullable: true),
                    Local_partida = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true),
                    Companhia = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true),
                    Num_voo = table.Column<string>(type: "nvarchar(10)", maxLength: 10, nullable: true),
                    Num_assento = table.Column<string>(type: "nvarchar(2)", maxLength: 2, nullable: true),
                    Qtd_assentos_disp = table.Column<int>(type: "int", nullable: false),
                    Data_partida = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    Data_chegada = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Voo", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Voo_Cidade_id_cidade",
                        column: x => x.id_cidade,
                        principalTable: "Cidade",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateTable(
                name: "Quarto",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    id_hotel = table.Column<int>(type: "int", nullable: true),
                    Numero = table.Column<int>(type: "int", nullable: false),
                    Valor = table.Column<double>(type: "float", nullable: false),
                    Diaria = table.Column<int>(type: "int", nullable: false),
                    Qtd_camas = table.Column<int>(type: "int", nullable: false),
                    Qtd_assentos_disp = table.Column<int>(type: "int", nullable: false),
                    Tipo = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Quarto", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Quarto_Hotel_id_hotel",
                        column: x => x.id_hotel,
                        principalTable: "Hotel",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateTable(
                name: "Registro_aluguel_quarto",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    id_quarto = table.Column<long>(type: "bigint", nullable: true),
                    Data_entrada = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    Data_saida = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Registro_aluguel_quarto", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Registro_aluguel_quarto_Quarto_id_quarto",
                        column: x => x.id_quarto,
                        principalTable: "Quarto",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateTable(
                name: "Pacote",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    id_voo_1 = table.Column<long>(type: "bigint", nullable: true),
                    id_voo_2 = table.Column<long>(type: "bigint", nullable: true),
                    id_registro_aluguel_quarto = table.Column<long>(type: "bigint", nullable: true),
                    Total_pessoas = table.Column<int>(type: "int", maxLength: 2, nullable: false),
                    Valor_original = table.Column<double>(type: "float", nullable: false),
                    Desconto = table.Column<int>(type: "int", nullable: false),
                    Valor_promocional = table.Column<double>(type: "float", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Pacote", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Pacote_Registro_aluguel_quarto_id_registro_aluguel_quarto",
                        column: x => x.id_registro_aluguel_quarto,
                        principalTable: "Registro_aluguel_quarto",
                        principalColumn: "Id");
                    table.ForeignKey(
                        name: "FK_Pacote_Voo_id_voo_1",
                        column: x => x.id_voo_1,
                        principalTable: "Voo",
                        principalColumn: "Id");
                    table.ForeignKey(
                        name: "FK_Pacote_Voo_id_voo_2",
                        column: x => x.id_voo_2,
                        principalTable: "Voo",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateTable(
                name: "Comprovante",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    id_registro_aluguel_quarto = table.Column<long>(type: "bigint", nullable: true),
                    id_usuario = table.Column<long>(type: "bigint", nullable: true),
                    id_pacote = table.Column<long>(type: "bigint", nullable: true),
                    Data_compra = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Comprovante", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Comprovante_Pacote_id_pacote",
                        column: x => x.id_pacote,
                        principalTable: "Pacote",
                        principalColumn: "Id");
                    table.ForeignKey(
                        name: "FK_Comprovante_Registro_aluguel_quarto_id_registro_aluguel_quarto",
                        column: x => x.id_registro_aluguel_quarto,
                        principalTable: "Registro_aluguel_quarto",
                        principalColumn: "Id");
                    table.ForeignKey(
                        name: "FK_Comprovante_Usuario_id_usuario",
                        column: x => x.id_usuario,
                        principalTable: "Usuario",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateIndex(
                name: "IX_Comprovante_id_pacote",
                table: "Comprovante",
                column: "id_pacote");

            migrationBuilder.CreateIndex(
                name: "IX_Comprovante_id_registro_aluguel_quarto",
                table: "Comprovante",
                column: "id_registro_aluguel_quarto");

            migrationBuilder.CreateIndex(
                name: "IX_Comprovante_id_usuario",
                table: "Comprovante",
                column: "id_usuario");

            migrationBuilder.CreateIndex(
                name: "IX_Hotel_id_cidade",
                table: "Hotel",
                column: "id_cidade");

            migrationBuilder.CreateIndex(
                name: "IX_Pacote_id_registro_aluguel_quarto",
                table: "Pacote",
                column: "id_registro_aluguel_quarto");

            migrationBuilder.CreateIndex(
                name: "IX_Pacote_id_voo_1",
                table: "Pacote",
                column: "id_voo_1");

            migrationBuilder.CreateIndex(
                name: "IX_Pacote_id_voo_2",
                table: "Pacote",
                column: "id_voo_2");

            migrationBuilder.CreateIndex(
                name: "IX_Quarto_id_hotel",
                table: "Quarto",
                column: "id_hotel");

            migrationBuilder.CreateIndex(
                name: "IX_Registro_aluguel_quarto_id_quarto",
                table: "Registro_aluguel_quarto",
                column: "id_quarto");

            migrationBuilder.CreateIndex(
                name: "IX_Usuario_id_cargo",
                table: "Usuario",
                column: "id_cargo");

            migrationBuilder.CreateIndex(
                name: "IX_Voo_id_cidade",
                table: "Voo",
                column: "id_cidade");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Comprovante");

            migrationBuilder.DropTable(
                name: "Pacote");

            migrationBuilder.DropTable(
                name: "Usuario");

            migrationBuilder.DropTable(
                name: "Registro_aluguel_quarto");

            migrationBuilder.DropTable(
                name: "Voo");

            migrationBuilder.DropTable(
                name: "Cargo");

            migrationBuilder.DropTable(
                name: "Quarto");

            migrationBuilder.DropTable(
                name: "Hotel");

            migrationBuilder.DropTable(
                name: "Cidade");
        }
    }
}
