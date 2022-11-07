using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Herlivre_api.Models;
using herlivre_api.Models;

namespace Herlivre_api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class QuartoController : ControllerBase
    {
        private readonly GeralDbContext _context;

        public QuartoController(GeralDbContext context)
        {
            _context = context;
        }

        // GET: api/Quarto
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Quarto>>> GetQuartos()
        {
            return await _context.Quartos.ToListAsync();
        }

        // GET: api/Quarto/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Quarto>> GetQuarto(long id)
        {
            var quarto = await _context.Quartos.FindAsync(id);

            if (quarto == null)
            {
                return NotFound();
            }

            return quarto;
        }

        // PUT: api/Quarto/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutQuarto(long id, Quarto quarto)
        {
            if (id != quarto.Id)
            {
                return BadRequest();
            }

            _context.Entry(quarto).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!QuartoExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Quarto
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Quarto>> PostQuarto(Quarto quarto)
        {
            _context.Quartos.Add(quarto);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetQuarto", new { id = quarto.Id }, quarto);
        }

        // DELETE: api/Quarto/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteQuarto(long id)
        {
            var quarto = await _context.Quartos.FindAsync(id);
            if (quarto == null)
            {
                return NotFound();
            }

            _context.Quartos.Remove(quarto);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool QuartoExists(long id)
        {
            return _context.Quartos.Any(e => e.Id == id);
        }
    }
}
