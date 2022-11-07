using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Diagnostics.CodeAnalysis;

namespace herlivre_api.Models
{



    [Table("Hotel")]
    public class Hotel
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }

        [ForeignKey("id_cidade")]
        public Cidade Cidade { get; set; }

        [StringLength(50)]
        public string Nome { get; set; }

        [MaxLength(5)]
        public int Qtd_estrelas { get; set; }

        public Double Valor_min { get; set; }

        public Boolean Wifi { get; set; }

        public Boolean Cafe_manha { get; set; }

        [StringLength(20)]
        public string Cep { get; set; }

        [StringLength(50)]
        public string Logradouro { get; set; }

        [StringLength(50)]
        public string Bairro { get; set; }


    }
}